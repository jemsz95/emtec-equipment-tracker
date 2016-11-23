export class MovementRecord {
  constructor(
    public id: number,
    public deviceId: number,
    public location: string,
    public date: Date
  ) { }
}
