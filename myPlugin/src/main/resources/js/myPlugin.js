
document.addEventListener('DOMContentLoaded', function() {
    var button = document.getElementById('Plagin-link');
    button.addEventListener('click', function() {
        alert('Кнопка нажата???????!');
        window.location.href = '/jira/plugins/servlet/database-console/login.do';
        console.log('Кнопка нажата?????????!');
    });
});

