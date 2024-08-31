import axios from 'axios';

const API_URL = 'http://localhost:8080';

const register = async (email, name, password) => {
  const formData = new FormData();
  formData.append('email', email);
  formData.append('name', name);
  formData.append('password', password);
  try {
    const response = await axios.post(`${API_URL}/join`, formData, {
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
    });

    return response.data;
  } catch (error) {
    throw new Error('회원가입 실패. 다시 시도해주세요.');
  }
};


const login = async (email, password) => {
  try {
    const response = await axios.post(`${API_URL}/login`, { email, password });
    return response.data;
  } catch (error) {
    throw new Error('로그인 실패. 다시 시도해주세요.');
  }
};

const logout = async () => {
  try {
    await axios.post(`${API_URL}/logout`);
  } catch (error) {
    throw new Error('로그아웃 실패. 다시 시도해주세요.');
  }
};

export default {
  register,
  login,
  logout,
};