/**
 * Creating a Util namesapce.  All functionality will be encapsulated within Util 
 * and Util will "expose" (API) the properties and functions that needs to be
 * exposed to the "outside" of this Util.
 * Usage:  var Util is declared and defined on the global scope (i.e. window.Util).
 * 
 * NOTE: Util is a "VERY" generic name.  Use a name that best describe the abstraction.
 * 
 */
var BUtil = (function(util) {
    "use strict";

    /**
     * Create a "bunch" of random objects (in the sense of 'You don't know JS' book)
     * and return those objects as an array.
     * Hence the structure returned will be:
     * [ {first-json-object-here},  {second-json-object-here}, ..., {n-json-object-here} ]
     * Also note:  int -> Array of objects.  Read as: Take int parameter and 
     * return an Array of object of size int.
     */
    util.createObjects = function createObj(quantity) {
        var objectArray = [];
        for (var i=0; i<quantity; i++) {
            var obj         = {}; // empty object
            // example of setting a property:
            obj.positionX = Math.floor(Math.random() * 100) + 1;  // a number between 1 and 100 (inclusive)
            // example of setting an internal/private function.  It is like attaching code (the function) to 
            // the object. But not executing it.
            obj.functionName = someFunction;
            // example of setting another object that may come from another lib.
            obj.objectFromAnotherLib = {}; // here you need to replace the call to create the object from another lib.
            objectArray.push(obj);
        }
        return objectArray;
    }
    
    // Simple property on the BUtil
    util.myProperty = 99;
    
    
    /**
     * Private function that will not be able to see from global scope and not even from Util.<functionNmae>
     * But will be available through Util.createObjects.functionName(parameter); from global scope.
     */
    var someFunction = function privateSomeFunction(param) {
        // this function will "always" be called from the context of Util.createObjects[index].functionName(value);
        // which means the "this" correspond to the current object we created in the array (i.e. the object at index)
        // So I can add a "new" propert on the current object.
        this.newProp = param + 2;
        // You can also do "some" computation here (but only when someFunction is called)
    }
    
    
    // IMPORTANT -> don't forget this statement :-)
    return util;
    
})(BUtil || {});

