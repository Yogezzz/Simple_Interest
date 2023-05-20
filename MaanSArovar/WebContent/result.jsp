<!DOCTYPE html>
<html>
<head>
    <title>Simple Interest Result</title>
</head>
<body>
    <h1>Simple Interest Result</h1>
    <p>Customer Name: <%= request.getAttribute("customerName") %></p>
    <p>Age: <%= request.getAttribute("age") %></p>
    <p>Principle Amount: <%= request.getAttribute("principleAmount") %></p>
    <p>Years: <%= request.getAttribute("years") %></p>
    <p>Rate: <%= request.getAttribute("rate") %></p>
    <p>Simple Interest: <%= request.getAttribute("simpleInterest") %></p>
</body>
</html>
