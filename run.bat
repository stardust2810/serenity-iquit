@ECHO ON
echo Options: [R]a, [C]lean, [V]erify, [N]ip, [A]bout, [U]AT, [E]NCF, [F]IA, [A]ll"
set /p answer=Enter selection:
if /i "%answer:~,1%" EQU "A" mvn clean verify -Dcucumber.options="--tags @nip --tags @encf"
if /i "%answer:~,1%" EQU "C" mvn clean
if /i "%answer:~,1%" EQU "V" mvn verify
if /i "%answer:~,1%" EQU "N" mvn clean verify -Dcucumber.options=" --tags @nip"
if /i "%answer:~,1%" EQU "F" mvn clean verify -Dcucumber.options=" --tags @fia"
if /i "%answer:~,1%" EQU "E" mvn clean verify -Dcucumber.options=" --tags @encf"
if /i "%answer:~,1%" EQU "R" mvn clean verify -Dcucumber.options=" --tags @ra"
if /i "%answer:~,1%" EQU "M" mvn clean verify -Dwebdriver.base.url=https://focos-m2.hpb.gov.sg
if /i "%answer:~,1%" EQU "T" mvn clean verify -Dcucumber.options=" --tags @tool" -Dwebdriver.base.url=https://focos.hpb.gov.sg
EXIT