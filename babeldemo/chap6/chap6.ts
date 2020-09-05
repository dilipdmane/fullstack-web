namespace MyFirstNameSpace
{
  export let homeworld = "jakku";
  export function sayName(){
    alert('Hello ...MyFirstNameSpace');
  };
}

function sayHi()
{
  MyFirstNameSpace.sayName();
}

sayHi();
