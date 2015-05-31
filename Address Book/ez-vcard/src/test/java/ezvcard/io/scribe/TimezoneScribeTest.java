package ezvcard.io.scribe;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

import ezvcard.VCardDataType;
import ezvcard.VCardVersion;
import ezvcard.io.scribe.Sensei.Check;
import ezvcard.property.Timezone;
import ezvcard.util.UtcOffset;

/*
 Copyright (c) 2012-2015, Michael Angstadt
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met: 

 1. Redistributions of source code must retain the above copyright notice, this
 list of conditions and the following disclaimer. 
 2. Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution. 

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

 The views and conclusions contained in the software and documentation are those
 of the authors and should not be interpreted as representing official policies, 
 either expressed or implied, of the FreeBSD Project.
 */

/**
 * @author Michael Angstadt
 */
public class TimezoneScribeTest {
	private final TimezoneScribe scribe = new TimezoneScribe();
	private final Sensei<Timezone> sensei = new Sensei<Timezone>(scribe);

	private final UtcOffset offset = new UtcOffset(false, -5, 0);
	private final String offsetStrExtended = "-05:00";
	private final String offsetStrBasic = "-0500";
	private final String timezoneIdStr = "America/New_York";
	private final String textStr = "some text";
	private final TimeZone newYork = TimeZone.getTimeZone(timezoneIdStr);

	private final Timezone withOffset = new Timezone(offset);
	private final Timezone withTimezoneId = new Timezone(timezoneIdStr);
	private final Timezone withText = new Timezone(textStr);
	private final Timezone withOffsetAndTimezoneId = new Timezone(offset, timezoneIdStr);
	private final Timezone empty = new Timezone((String) null);

	@Test
	public void prepareParameters() {
		sensei.assertDataType(withOffset).run(VCardDataType.UTC_OFFSET);

		sensei.assertDataType(withTimezoneId).versions(VCardVersion.V2_1).run(VCardDataType.UTC_OFFSET);
		sensei.assertDataType(withTimezoneId).versions(VCardVersion.V3_0, VCardVersion.V4_0).run(VCardDataType.TEXT);

		sensei.assertDataType(withText).versions(VCardVersion.V2_1).run(VCardDataType.UTC_OFFSET);
		sensei.assertDataType(withText).versions(VCardVersion.V3_0, VCardVersion.V4_0).run(VCardDataType.TEXT);

		sensei.assertDataType(withOffsetAndTimezoneId).versions(VCardVersion.V2_1, VCardVersion.V3_0).run(VCardDataType.UTC_OFFSET);
		sensei.assertDataType(withOffsetAndTimezoneId).versions(VCardVersion.V4_0).run(VCardDataType.TEXT);

		sensei.assertDataType(empty).versions(VCardVersion.V2_1, VCardVersion.V3_0).run(VCardDataType.UTC_OFFSET);
		sensei.assertDataType(empty).versions(VCardVersion.V4_0).run(VCardDataType.TEXT);
	}

	@Test
	public void writeText() {
		sensei.assertWriteText(withOffset).versions(VCardVersion.V2_1, VCardVersion.V4_0).run(offsetStrBasic);
		sensei.assertWriteText(withOffset).versions(VCardVersion.V3_0).run(offsetStrExtended);

		sensei.assertWriteText(withTimezoneId).versions(VCardVersion.V2_1).run(newYork.inDaylightTime(new Date()) ? "-0400" : "-0500");
		sensei.assertWriteText(withTimezoneId).versions(VCardVersion.V3_0, VCardVersion.V4_0).run(timezoneIdStr);

		sensei.assertWriteText(withText).versions(VCardVersion.V2_1).run("");
		sensei.assertWriteText(withText).versions(VCardVersion.V3_0, VCardVersion.V4_0).run(textStr);

		sensei.assertWriteText(withOffsetAndTimezoneId).versions(VCardVersion.V2_1).run(offsetStrBasic);
		sensei.assertWriteText(withOffsetAndTimezoneId).versions(VCardVersion.V3_0).run(offsetStrExtended);
		sensei.assertWriteText(withOffsetAndTimezoneId).versions(VCardVersion.V4_0).run(timezoneIdStr);

		sensei.assertWriteText(empty).run("");
	}

	@Test
	public void writeXml() {
		sensei.assertWriteXml(withOffset).run("<utc-offset>" + offsetStrBasic + "</utc-offset>");
		sensei.assertWriteXml(withTimezoneId).run("<text>" + timezoneIdStr + "</text>");
		sensei.assertWriteXml(withOffsetAndTimezoneId).run("<text>" + timezoneIdStr + "</text>");
		sensei.assertWriteXml(empty).run("<text/>");
	}

	@Test
	public void writeJson() {
		sensei.assertWriteJson(withOffset).run(offsetStrExtended);
		sensei.assertWriteJson(withTimezoneId).run(timezoneIdStr);
		sensei.assertWriteJson(withOffsetAndTimezoneId).run(timezoneIdStr);
		sensei.assertWriteJson(empty).run("");
	}

	@Test
	public void parseText() {
		sensei.assertParseText(offsetStrExtended).run(is(withOffset));
		sensei.assertParseText(offsetStrExtended).dataType(VCardDataType.UTC_OFFSET).run(is(withOffset));
		sensei.assertParseText(offsetStrExtended).dataType(VCardDataType.TEXT).run(is(withOffset));

		sensei.assertParseText(timezoneIdStr).versions(VCardVersion.V2_1).cannotParse();
		sensei.assertParseText(timezoneIdStr).versions(VCardVersion.V3_0).warnings(1).run(is(withTimezoneId));
		sensei.assertParseText(timezoneIdStr).versions(VCardVersion.V3_0).dataType(VCardDataType.UTC_OFFSET).warnings(1).run(is(withTimezoneId));
		sensei.assertParseText(timezoneIdStr).versions(VCardVersion.V3_0).dataType(VCardDataType.TEXT).run(is(withTimezoneId));
		sensei.assertParseText(timezoneIdStr).versions(VCardVersion.V4_0).run(is(withTimezoneId));
		sensei.assertParseText(timezoneIdStr).versions(VCardVersion.V4_0).dataType(VCardDataType.UTC_OFFSET).warnings(1).run(is(withTimezoneId));
		sensei.assertParseText(timezoneIdStr).versions(VCardVersion.V4_0).dataType(VCardDataType.TEXT).run(is(withTimezoneId));

		sensei.assertParseText("").run(is(empty));
	}

	@Test
	public void parseXml() {
		sensei.assertParseXml("<utc-offset>" + offsetStrBasic + "</utc-offset>").run(is(withOffset));
		sensei.assertParseXml("<text>" + timezoneIdStr + "</text>").run(is(withTimezoneId));
		sensei.assertParseXml("<utc-offset>" + offsetStrBasic + "</utc-offset><text>" + timezoneIdStr + "</text>").run(is(withTimezoneId));
		sensei.assertParseXml("<utc-offset>invalid</utc-offset>").cannotParse();
		sensei.assertParseXml("").cannotParse();
	}

	@Test
	public void parseHtml() {
		sensei.assertParseHtml("<div>" + offsetStrExtended + "</div>").run(is(withOffset));
		sensei.assertParseHtml("<div>" + timezoneIdStr + "</div>").run(is(withTimezoneId));
		sensei.assertParseHtml("<div></div>").run(is(empty));
	}

	@Test
	public void parseJson() {
		sensei.assertParseJson(offsetStrExtended).run(is(withOffset));
		sensei.assertParseJson(offsetStrExtended).dataType(VCardDataType.UTC_OFFSET).run(is(withOffset));
		sensei.assertParseJson(offsetStrExtended).dataType(VCardDataType.TEXT).run(is(withOffset));

		sensei.assertParseJson(timezoneIdStr).run(is(withTimezoneId));
		sensei.assertParseJson(timezoneIdStr).dataType(VCardDataType.UTC_OFFSET).warnings(1).run(is(withTimezoneId));
		sensei.assertParseJson(timezoneIdStr).dataType(VCardDataType.TEXT).run(is(withTimezoneId));

		sensei.assertParseJson("").dataType(VCardDataType.TEXT).run(is(empty));
	}

	private Check<Timezone> is(final Timezone expected) {
		return new Check<Timezone>() {
			public void check(Timezone actual) {
				assertEquals(expected.getOffset(), actual.getOffset());
				assertEquals(expected.getText(), actual.getText());
			}
		};
	}
}
