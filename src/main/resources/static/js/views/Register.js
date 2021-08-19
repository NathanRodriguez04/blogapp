import createView from "../createView.js";

export default function Register(props) {
    return `
     <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="UTF-8"/>
                    <title>Register</title>
                </head>
                <body>
                    <h1>Register</h1>
                    <form id="register-form">
                        <label for="username">Username</label>
                        <input id="username" name="username" type="text"/>
                        <label for="email">Email</label>
                        <input id="email" name="email" type="text">
                        <label for="password">Password</label>
                        <input id="password" name="password" type="password"/>
                        <button id="register-btn" type="button">Register</button>
                    </form>
                </body>
            </html>
`;




}


export function RegisterEvent() {
    $("#register-btn").click(function () {
        let user = {
            username: $("#username").val(),
            email: $("#email").val(),
            password: $("#password").val()

        }
        let request = {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(user)
        }
        console.log(request)
        fetch("http://localhost:8080/api/users", request)
            .then((response) =>{
                console.log(response.status)
                createView("/");
            })
    });
}