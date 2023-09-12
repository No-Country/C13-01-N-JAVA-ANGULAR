export interface UserRegister {
  email: string;
  password: string;
  role: string;
}

export interface UserLogin {
  email: string;
  password: string;
}

export interface ResLogin {
  id: number;
  token: string;
  message: string;
}
export interface ResRegister {
  id: number;
  accessToken: string;
  message: string;
}

export interface User {
  id?: string;
  email: string;
  role: string;
}
