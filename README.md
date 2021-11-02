# Coding assessment for QuantCast: Most Active Cookie(s)

## Instructions:

### To execute-

1. Download the activecookie-sudheendra-0.0.1-SNAPSHOT.jar from target/
2. $> java -jar activecookie-sudheendra-0.0.1-SNAPSHOT.jar "path/to/cookie/log/in/csv" -d yyyy-mm-dd

### To test and build

1. Clone the repo: git clone https://github.com/sudheendrakatikar/quantcast-assessment.git
2. mvn clean instal
3. mvn test
4. mvn package (to build the jar)

## Test cases:

### Sample cookie logs-
cookie,timestamp
AtY0laUfhglK3lC7,2018-12-09T14:19:00+00:00
SAZuXPGUrfbcn5UA,2018-12-09T10:13:00+00:00
5UAVanZf6UtGyKVS,2018-12-09T07:25:00+00:00
AtY0laUfhglK3lC7,2018-12-09T06:19:00+00:00
SAZuXPGUrfbcn5UA,2018-12-08T22:03:00+00:00
4sMM2LxV07bPJzwf,2018-12-08T21:30:00+00:00
fbcn5UAVanZf6UtG,2018-12-08T09:30:00+00:00
4sMM2LxV07bPJzwf,2018-12-07T23:30:00+00:00

$> java -jar activecookie-sudheendra-0.0.1-SNAPSHOT.jar S:\eclipse-workspace\activecookie-sudheendra\src\test\resources\cookie_log.csv -d 2018-12-09
AtY0laUfhglK3lC7

$> java -jar activecookie-sudheendra-0.0.1-SNAPSHOT.jar S:\eclipse-workspace\activecookie-sudheendra\src\test\resources\cookie_log.csv -d 2018-12-08
fbcn5UAVanZf6UtG
SAZuXPGUrfbcn5UA
4sMM2LxV07bPJzwf
