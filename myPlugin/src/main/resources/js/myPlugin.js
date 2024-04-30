
document.addEventListener('DOMContentLoaded', function() {
    var button = document.getElementById('Plagin-link');
    button.addEventListener('click', function() {
        alert('Кнопка нажата???????!');
        window.location.href = '/task';
        console.log('Кнопка нажата?????????!');
    });
});

