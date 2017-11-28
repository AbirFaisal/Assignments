git remote add -f COP2220 https://github.com/AbirFaisal/COP2220.git
git merge -s ours --no-commit COP2220/master --allow-unrelated-histories
git read-tree --prefix=COP2220/ -u COP2220/master
git commit -m "Merged COP2220"


git remote add -f COP2800 https://github.com/AbirFaisal/COP2800.git
git merge -s ours --no-commit COP2800/master --allow-unrelated-histories
git read-tree --prefix=COP2800/ -u COP2800/master
git commit -m "Merged COP2800"


git remote add -f COP2805C https://github.com/AbirFaisal/COP2805C.git
git merge -s ours --no-commit COP2805C/master --allow-unrelated-histories
git read-tree --prefix=COP2805C/ -u COP2805C/master
git commit -m "Merged COP2805C"


git remote add -f COP2800GroupWork https://github.com/AbirFaisal/COP2800GroupWork.git
git merge -s ours --no-commit COP2800GroupWork/master --allow-unrelated-histories
git read-tree --prefix=COP2800GroupWork/ -u COP2800GroupWork/master
git commit -m "Merged COP2800GroupWork"


git remote add -f COP2805C-Group-Work https://github.com/AbirFaisal/COP2805C-Group-Work.git
git merge -s ours --no-commit COP2805C-Group-Work/master --allow-unrelated-histories
git read-tree --prefix=COP2805C-Group-Work/ -u COP2805C-Group-Work/master
git commit -m "Merged COP2805C-Group-Work"
