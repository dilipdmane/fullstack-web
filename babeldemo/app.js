var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
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
    var firstName = person.firstName, lastName = person.lastName, age = person.age;
    console.log(firstName);
    // Addd Spread operator
    // const addNumber = (num1?: number,num2?: number):number=>num1+num2;
    // const nums:number[] = [5,5];
    // console.log( addNumber(...nums));
    var planet = new Planet('Dilip', 59);
    planet.name = 'Tested';
    console.log(planet.name);
    /*let j:Jupiter = new Jupiter();

    console.log(j.calcSuperClass(4));*/
    function greet(person) {
        alert(person.getFullName());
    }
    var Person2 = /** @class */ (function () {
        function Person2(inFirstName, inLastName) {
            this.firstName = inFirstName;
            this.lastName = inLastName;
        }
        Person2.prototype.getFullName = function () {
            return this.firstName.concat(' ').concat(this.lastName);
        };
        return Person2;
    }());
    var person2 = new Person2("Dilip", "Patil");
    greet(person2);
}
var Planet = /** @class */ (function () {
    function Planet(inName, inMass) {
        this._name = "none";
        this._name = inName;
        this._mass = inMass;
    }
    Planet.prototype.printName = function () {
        alert(this._name);
    };
    Object.defineProperty(Planet.prototype, "name", {
        get: function () {
            return this._name;
        },
        set: function (inName) {
            if (inName == "Pluto") {
                this._name = "Not a planet";
            }
            else {
                this._name = inName;
            }
        },
        enumerable: true,
        configurable: true
    });
    /**
     * calcSuperClass
  massMultiple?:number=2 :number  */
    Planet.prototype.calcSuperClass = function (massMultiple) {
        if (massMultiple === void 0) { massMultiple = 2; }
        return this._mass * massMultiple;
    };
    return Planet;
}());
var Jupiter = /** @class */ (function (_super) {
    __extends(Jupiter, _super);
    function Jupiter() {
        var _this = _super.call(this, 'Juipter', 500) || this;
        _this.colorBands = true;
        return _this;
    }
    /**
     * printJupiterName
     this.*/
    Jupiter.prototype.printJupiterName = function () {
        console.log('Called using child class....');
        this.printName();
    };
    return Jupiter;
}(Planet));
function concate(string1, string2) {
    return string1 + string2;
}
sayHi('React ');
