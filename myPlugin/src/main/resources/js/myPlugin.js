<script>
    function populateTable() {
        var rowCount = document.getElementById('rowCount').value;
        var table = document.getElementById('taskTable');
        table.innerHTML = '';
        fetch('/getTasks?rowCount=' + rowCount)
            .then(response => response.json())
            .then(data => {
                data.forEach(task => {
                    var row = table.insertRow();
                    row.innerHTML = '<td>' + task.issueKey + '</td>' +
                                    '<td>' + task.summary + '</td>' +
                                    '<td>' + task.reporter + '</td>' +
                                    '<td>' + task.dueDate + '</td>';
                });
            });
    }
    function sortTable(columnIndex) {
        var table, rows, switching, i, x, y, shouldSwitch;
        table = document.getElementById('taskTable');
        switching = true;
        while (switching) {
            switching = false;
            rows = table.rows;
            for (i = 1; i < (rows.length - 1); i++) {
                shouldSwitch = false;
                x = rows[i].getElementsByTagName('td')[columnIndex];
                y = rows[i + 1].getElementsByTagName('td')[columnIndex];
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            }
            if (shouldSwitch) {
                rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                switching = true;
            }
        }
    }
    window.onload = populateTable;
</script>
