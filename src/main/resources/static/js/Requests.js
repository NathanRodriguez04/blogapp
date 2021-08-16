fetch("http://localhost:8080/api/posts", {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    },
    redirect: 'follow',
}).then(function(response) {
    return response.json();
}).then(function(data) {
    console.log(data);
});
