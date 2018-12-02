var fs = require('fs');
var csv = require('csv');
var csv_export=require('csv-export');
var sentiment = require('sentiment');


var table1 = [];
var stream = fs.createReadStream("reviews.csv");
 
var csvStream = csv
    .parse()
    .on("data", function(data){
         console.log(data[0]);
	var temp_table = [];
	var r1 = sentiment(data[5]);
	//temp_table.push(data[0]);
	temp_table.push(data[3]);
	//temp_table.push(r1.score);
	table1.push(temp_table);	
    })
    .on("end", function(){
         console.log("done");
	csv_export.export(table1,function(buffer){
 
  //this module returns a buffer for the csv files already compressed into a single zip. 
  //save the zip or force file download via express or other server 
  fs.writeFileSync('./New folder/out.zip',buffer);
 
});
    });
 
stream.pipe(csvStream);
/**/