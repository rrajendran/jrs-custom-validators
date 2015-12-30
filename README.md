# jrs-custom-validators
Adding custom JSR-303 Validators


@ValidDate
===============
Validates if the give string has a valid startDate or not. Can provide startDate format also. Default is yyyy-MM-dd
<br />
Example
<br />
@ValidDate(format="dd-MM-yyyy")
<br />
String startDate;

