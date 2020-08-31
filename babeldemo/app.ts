function sayHi(humanName:string)
{
  const SMALL = 0;
  const MEDIUM = 100;
  const LARGE = 2;
  enum Size {SMALL,MEDIUM,LARGE};
   let a:string[] ;
   a=["50","55"];
    console.log(concate(`Hi ${humanName}...`,`Compiled with Typescript complier It's fun! `));
    let myAppSize:Size;
    myAppSize = Size.LARGE;
    //alert(myAppSize);

    // Understand object type definitions
    type personType={firstName:string,lastName:string,age:number};
    let person:personType={firstName:"Dilip",lastName:"Mane",age:52};
    console.log(person);

    // Addd Spread operator
    const addNumber = (num1?: number,num2?: number):number=>num1+num2;
    const nums:number[] = [5,5];
    console.log( addNumber(...nums));

}

function concate( string1:string, string2:string):string{
  return string1+string2;
}

sayHi( 'React ');
