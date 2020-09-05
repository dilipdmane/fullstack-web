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

    const { firstName,lastName,age } = person
    console.log(firstName);

    // Addd Spread operator
    // const addNumber = (num1?: number,num2?: number):number=>num1+num2;
    // const nums:number[] = [5,5];
    // console.log( addNumber(...nums));
     let planet:Planet = new Planet('Dilip',59);

    planet.name='Tested';

    console.log(planet.name);

    /*let j:Jupiter = new Jupiter();

    console.log(j.calcSuperClass(4));*/

    function greet(person: IPerson) {
      alert(person.getFullName());
    }



    interface IPerson{
      firstName:string;
      lastName:string;

      getFullName():string;

    }

    class Person2 implements IPerson
    {
      firstName:string;
      lastName:string;

      constructor(inFirstName:string,inLastName:string)
      {
        this.firstName = inFirstName;
        this.lastName = inLastName;
      }

      getFullName():string{
        return this.firstName.concat(' ').concat(this.lastName);
      }

    }

    let person2 = new Person2("Dilip","Patil");

    greet(person2);
}

class Planet {
  private _name:string="none";
  protected _mass:number
  constructor(inName:string, inMass:number) {
    this._name=inName;
    this._mass=inMass;
  }

  public printName()
  {
    alert(this._name)
  }

  set name(inName: string)
  {
    if (inName=="Pluto") {
      this._name = "Not a planet"
    }
    else
    {
      this._name=inName;
    }
  }

 get name()
 {
   return this._name;
 }
  /**
   * calcSuperClass
massMultiple?:number=2 :number  */
  public calcSuperClass(massMultiple:number=2) :number{
    return this._mass*massMultiple;
  }
}

class Jupiter extends Planet
{
  private colorBands:boolean = true;
  constructor()
  {
    super('Juipter',500);
  }

  /**
   * printJupiterName
   this.*/
  public printJupiterName() {
    console.log('Called using child class....')
    this.printName();
  }
}

function concate( string1:string, string2:string):string{
  return string1+string2;
}

sayHi( 'React ');
