import fetchData from "../fetchData.js";

export default function PostIndex(props) {
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
<!--MAKE CREATE FORM HERE--> 
       <form>

    <label for="username">Username</label>
    <input id="username" name="username" type="text">
    <br>

    <label for="password">Password</label>
    <input id="password" name="password" type="password">
    <br>

    <input type="button" id="create-post-btn">
</form>
            
            <div class="post-container">
                ${props.posts.map(post =>
        `
                        <h3>${post.title}</h3>
                        <h2>${post.content}</h2>
       <!--add edit, delete buttons, add edit form-->
        
        
        `).join('')}   
            </div>
            
            
        </main>
    `;
}
//add event listeners, get data, send fetch
//call function for edit btns listener
//call function for data
//call function for fetch
export function PostsEvent() {
    $('#create-post-btn').click(function () {

        let post = {
            title: $("#title").val(),
            content: $("#content").val()
        }
        console.log(post)


        let request = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(post)
        }
        fetchData({
                post: '/api/posts'
            },
            request)

    });
}