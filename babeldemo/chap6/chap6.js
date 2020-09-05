var MyFirstNameSpace;
(function (MyFirstNameSpace) {
    MyFirstNameSpace.homeworld = "jakku";
    function sayName() {
        alert('Hello ...MyFirstNameSpace');
    }
    MyFirstNameSpace.sayName = sayName;
    ;
})(MyFirstNameSpace || (MyFirstNameSpace = {}));
function sayHi() {
    MyFirstNameSpace.sayName();
}
sayHi();
