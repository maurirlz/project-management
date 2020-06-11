const decodeHtml = (html) => {
    let txt = document.createElement("textarea")
    txt.innerHTML = html;
    return txt.value;
}
const chartDataStr = decodeHtml(chartData); // from home.html in <script> tag

let jsonData = JSON.parse(chartDataStr);

const numericData = [];
let labelData = [];

jsonData.forEach(jsonData => {
    numericData.push(jsonData.value);
    labelData.push(jsonData.label);
});

new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ['#0B0C10', '#4ed7d2', '#C5C6C7'],
            data: numericData,
            borderColor: "#1F2833"
        }],
    },
    options: {
        title: {
            display: true,
            text: 'Projects status',
        },
    },
});

