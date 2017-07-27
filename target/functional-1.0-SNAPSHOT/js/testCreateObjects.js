"use strict";
// Note: we assume that createEntities.js has been included.
var quantity = 25;
console.log("testing....");
console.log("myProperty: " + BUtil.myProperty);
var myArrayOfObjects = BUtil.createObjects(quantity); // Will create 25 random objects.

for (var i=0; i<quantity; i++) {
    // Do something with the randomly created objects.
    var obj = myArrayOfObjects[i];
    // access a property
    console.log(obj.positionX);
    
    // call a function 
    obj.functionName(10); // will assign (10+2) to newProp
    console.log(obj.newProp);
    
    // access object that came from another lib
    console.log(typeof obj.objectFromAnotherLib);
    
    // we cannot call "BUtil.someFunction(param);" directly, we
    // have to call it through each created object: obj.functionName(...);
    // BUtil.someFunction(12); // ERROR
}



