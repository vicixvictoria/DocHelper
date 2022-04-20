import {Gender} from "../global/gender";

export class Patient {
  constructor(
    public id: number,
    public firstName: string,
    public lastName: string,
    public svnr: number,
    public pregnant: boolean,
    public birthDate: Date,
    public gender: Gender
  )
  {
  }
}
