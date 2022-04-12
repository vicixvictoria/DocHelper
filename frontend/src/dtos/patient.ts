export class Patient {
  constructor(
    public id: number,
    public name: string,
    public address: string,
    public svnr: number,
    public tests: number[],
    public birthday: Date) {
  }
}
