export interface Reservation {
  title: string;
  date: string;
  price: number;
  doctor: {
    id: number;
  };
  patient: {
    id: number;
  };
  status: Status;
}

export enum Status {
  PENDING = 'PENDING',
  CONFIRMED = 'CONFIRMED',
  CANCELLED = 'CANCELLED',
  COMPLETED = 'COMPLETED',
  REJECTED = 'REJECTED',
}
