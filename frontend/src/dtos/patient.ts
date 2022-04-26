import {Sex} from "../global/sex";


export class Patient {
  constructor(
    public id: number,
    public firstName: string,
    public lastName: string,
    public svnr: number,
    public pregnant: boolean,
    public birthDate: Date,
    public sex: Sex
  )
  {
  }
}
