export interface UserRegister {
  email: string;
  password: string;
  role: string;
}

export interface UserLogin {
  email: string;
  password: string;
}

export interface ResAuth {
  id: number;
  token: string;
  message: string;
}

export interface User {
  id?: string;
  email: string;
  role: string;
}

export interface DoctorRegister {
  id?: number;
  name: string;
  lastname: string;
  email: string;
  password: string;
  specialty: string;
  phone: string;
  address: string;
  paymentTypes: string;
  role: string;
}
