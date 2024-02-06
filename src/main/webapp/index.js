function convertToBase(convertTo) {
    let decimalInput = document.getElementById("decimalInput").value;

    // Client-side validation
    if (!decimalInput.match(/^\d+$/)) {
        alert("Please enter a valid decimal number.");
        return;
    }

    // Send the input to the servlet for conversion
    fetch("ConverterServlet?decimal=" + decimalInput + "&convertTo=" + convertTo)
        .then(response => response.text())
        .then(data => {
            document.getElementById("conversionResult").innerHTML = data;
        })
        .catch(error => {
            console.error("Error:", error);
        });
}

function clearInput() {
    document.getElementById("decimalInput").value = "";
    document.getElementById("conversionResult").innerHTML = "";
}