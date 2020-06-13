//Program read a JSON file, change the value and write it to new file
var fs = require('fs');
        //reading the JSON file
        fs.readFile('employee.json', 'utf8',(err, data) => {
            //Creating the objects to access the required object value
            const jsonObject = JSON.parse(data);
            const employee = jsonObject.employee;
            const companyName = employee.companyName;
            //Checking for the company name
            if(companyName=='Wipro'){
                //Storing in different object
                const data2 = (data.replace('Wipro', 'Wipro Ltd'));
                //Writing the changed value to the new file
                fs.writeFile("employee1.json", data2, function (err) {
                    if(err){
                        console.log(err);
                    }
                })
            }
            else {
                console.log("company name matching to Wipro Ltd");
            }}
        )