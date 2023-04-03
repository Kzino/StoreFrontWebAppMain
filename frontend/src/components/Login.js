import {  useState } from "react";
import { useNavigate } from 'react-router-dom';
import axios from "axios";


function Login() {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();


    async function login(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8081/api/v1/user/login", {
                email: email,
                password: password,
            }
            ).then((res) =>
            {
                console.log(res.data);

                if (res.data.message == "Email Address does not exists")
                {
                    alert("Email Address does not exits");
                }
                else if(res.data.message == "Login Successful!")
                {

                    navigate('/home');
                }
                else
                {
                    alert("Incorrect Email or Password");
                }
            }, fail => {
                console.error(fail); // Error!
            });
        }

        catch (err) {
            alert(err);
        }

    }

    return (
        <div>
            <div className="container">
                <div className="row">
                    <h2>Login</h2>
                    <hr/>
                </div>

                <div className="row">
                    <div className="col-sm-6">
                        <form>
                            <div className="form-group">
                                <label>Email Address</label>
                                <input type="email"  className="form-control" id="email" placeholder="Enter Email Address"

                                       value={email}
                                       onChange={(event) => {
                                           setEmail(event.target.value);
                                       }}

                                />

                            </div>

                            <div className="form-group">
                                <label>Password</label>
                                <input type="password"  className="form-control" id="password" placeholder="Enter Password"

                                       value={password}
                                       onChange={(event) => {
                                           setPassword(event.target.value);
                                       }}

                                />
                            </div>
                            <button type="submit" className="btn btn-primary" onClick={login}>Login</button>
                        </form>

                    </div>
                </div>
            </div>

        </div>
    );
}

export default Login;