import fetchData from "../fetchData.js";
import createView from "../createView.js";

export default function PostIndex(props) {
    return `
               <header>
                <h1>Posts Page</h1>
            </header>
            <main>
                <!--MAKE CREATE FORM HERE-->
                <form>
                    <label for="title">Title</label>
                    <input id="title" name="title" type="text">
                    <br>
                    <label for="content">content</label>
                    <input id="content" name="content" type="content">
                    <br>
                    <input type="button" id="create-post-btn" value="Add Post">
                </form>
                <div class="post-container">
                    ${props.posts.map(post =>
        `<div class="post">
                        <h3 class="post-title">${post.title}</h3>
                        <h2 class="post-content">${post.content}</h2>
                        <button class="post-edit-btn" type="button" data-id="${post.id}">EDIT</button>
                        <button class="post-delete-btn" type="button" data-id="${post.id}">DELETE</button>
                    </div>
                 
                    `).join('')}
                </div>
            </main>
    `;
}


export function PostsEvent() {
    createPostEvent()
    editPostEvent()
    deletePostEvent()

}


function createPostEvent() {
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


        fetch("http://localhost:8080/api/posts", request).then(createView("/posts"));

    })
}

function editPostEvent() {
    $('.post-edit-btn').click(function () {

        $(this).siblings(".post-title, .post-content").attr("contenteditable", true)
        $(this).text("save")
        $(this).on("click", submitEditEvent)

    })
}

function submitEditEvent() {
    let post = {
        title: $(this).siblings(".post-title").text(),
        content: $(this).siblings(".post-content").text()
    }
    console.log(post)

    resetEditEvents()


    console.log("SubmitEvent fired off")


    let request = {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(post)
    }
    let id = $(this).attr("data-id")
    fetch(`http://localhost:8080/api/posts/${id}`, request).then(response => {
        console.log(response.status)
        createView("/posts")
    })

}

function resetEditEvents() {
    $(this).siblings(".post-title, .post-content").attr("contenteditable", false)
    $(this).text("Edit")
    $(this).off("click", submitEditEvent)
}

function deletePostEvent() {
    $('.post-delete-btn').click(function () {
        let request = {
            method: 'DELETE',
            headers: {'Content-Type': 'application/json'},
        }
        let id = $(this).attr("data-id")
        fetch(`http://localhost:8080/api/posts/${id}`, request).then(response => {
            console.log(response.status)
            createView("/posts")
        })
    })

}
