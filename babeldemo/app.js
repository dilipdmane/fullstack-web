function sayHi(humanName) {
    var SMALL = 0;
    var MEDIUM = 100;
    var LARGE = 2;
    var Size;
    (function (Size) {
        Size[Size["SMALL"] = 0] = "SMALL";
        Size[Size["MEDIUM"] = 1] = "MEDIUM";
        Size[Size["LARGE"] = 2] = "LARGE";
    })(Size || (Size = {}));
    ;
    var a;
    a = ["50", "55"];
    console.log(concate("Hi " + humanName + "...", "Compiled with Typescript complier It's fun! "));
    var myAppSize;
    myAppSize = Size.LARGE;
    var person = { firstName: "Dilip", lastName: "Mane", age: 52 };
    console.log(person);
    // Addd Spread operator
    var addNumber = function (num1, num2) { return num1 + num2; };
    var nums = [5, 5];
    console.log(addNumber.apply(void 0, nums));
}
function concate(string1, string2) {
    return string1 + string2;
}
sayHi('React ');
