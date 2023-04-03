import {  useState } from "react";

import axios from "axios";

function Register() {

    const [username, setUserName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");


    async function save(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8081/api/v1/user/save", {
                username: username,
                email: email,
                password: password,
            },
                { withCredentials: false }
            );
            alert("User Registration Successful!");

        } catch (err) {
            alert(err);
        }
    }

    return (
        <div>
            <div class="container mt-4" >
                <div class="card">
                    <h1>User Registration</h1>

                    <form>
                        <div className="form-group">
                            <label>User Name</label>
                            <input type="text"  className="form-control" id="username" placeholder="Enter User Name"

                                   value={username}
                                   onChange={(event) => {
                                       setUserName(event.target.value);
                                   }}
                            />

                        </div>

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

                        <button type="submit" className="btn btn-primary mt-4" onClick={save} >Register</button>

                    </form>
                </div>
            </div>
        </div>
    );
}

export default Register;