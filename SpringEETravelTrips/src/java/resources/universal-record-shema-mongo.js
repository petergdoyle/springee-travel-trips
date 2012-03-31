/* 
 *  sample mongoDB script snippets 
 */

ur = {
    id : 0,
    createDate: new Date(),
    airSegments: [
        airSegment = {
            id : 0,
            createDate: new Date(),
            flightDetail : {                
                id : 1,
                departureAirportCode: 'DEN', 
                departureTime: ISODate("2012-03-25T10:00:00.0Z"),
                arrivalAirportCode: "", 
                arrivalTime : ISODate("2012-03-25T14:00:00.0Z"),
                airline : "United Airlines",
                airlineCode : "UA",
                airlineFlightNumber : "UA3920", 
                classOfService : "Econmy", 
                price :  214.00
            },
            passengerDetails : [
                passengerDetail = {
                    id : 1,
                    firstName : "Peter", 
                    lastName : "Doyle",       
                    initials : "G",   
                    contactPhone : "303 262 1828",
                    contactEmail : "peter.doyle@travelport.com",
                    countryOfResidenceCode : "USA",
                    countryOfNationalityCode : "CAN",
                    passportId : "A9238 2828", 	
                    "dateOfBirth" : ISODate("1982-03-28T11:15:15.685Z"), 	
                    "valuedCustomer" : true 
                }
            ],    
            formOfPayments : [
                formOfPayment = {
                    id : 0,
                    formOfPaymentType: "VS",
                    creditCardNumber: "3928 2828 2830 2291",
                    creditCardName: "Peter G Doyle",
                    creditExpiry: "01/14",
                    creditCcid: "389"
                }
            ]
        },            
        airSegment = {
            id : 0,
            createDate: new Date(),
            flightDetail : {                
                id : 1,
                departureAirportCode: 'JFK', 
                departureTime: ISODate("2012-03-25T09:00:00.0Z"),
                arrivalAirportCode: "", 
                arrivalTime : ISODate("2012-03-25T13:00:00.0Z"),
                airline : "United Airlines",
                airlineCode : "UA",
                airlineFlightNumber : "UA2387", 
                classOfService : "Econmy", 
                price :  287.00
            },
            passengerDetails : [
                passengerDetail = {
                    id : 1,
                    firstName : "Peter", 
                    lastName : "Doyle",       
                    initials : "G",   
                    contactPhone : "303 262 1828",
                    contactEmail : "peter.doyle@travelport.com",
                    countryOfResidenceCode : "USA",
                    countryOfNationalityCode : "CAN",
                    passportId : "A9238 2828",
                    "dateOfBirth" : ISODate("1982-03-28T11:15:15.685Z"), 	
                    "valuedCustomer" : true 
                }
            ],    
            formOfPayments : [
                formOfPayment = {
                    id : 0,
                    formOfPaymentType: "VS",
                    creditCardNumber: "3928 2828 2830 2291",
                    creditCardName: "Peter G Doyle",
                    creditExpiry: "01/14",
                    creditCcid: "389"
                }
            ]   
        }
    ]        
}
db.universalRecords.save(ur) /* save the document record */
db.universalRecords.find({id: 0}) /* find the document by id property value */
db.universalRecords.find().count(); /* return the count of documents */
db.universalRecords.remove() /* remove all documents in this collection */
db.universalRecords.find({_id: ObjectId("4f6f4da5b923be67372d9893")}) /* find document by generatd mogon _id */


fd1 = {          
    departureAirportCode: 'JFK', 
    departureTime: ISODate("2012-03-25T09:00:00.0Z"),
    arrivalAirportCode: "DEN", 
    arrivalTime : ISODate("2012-03-25T13:00:00.0Z"),
    airline : "United Airlines",
    airlineCode : "UA",
    airlineFlightNumber : "UA2387", 
    classOfService : "Econmy", 
    price :  287.00
}
db.availableFlights.save(fd1) /* save the document record */