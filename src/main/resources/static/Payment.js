const paymentStart = () => {
    console.log("Payment start successfully ... ");
    var value = document.getElementById("amount").value;
    console.log("value = " + value);

    if (value == "" || value == null) {
        alert("pls enter amount ... ");
        return;
    }

    $.ajax(
        {
            url: "/create_order",
            data: JSON.stringify({ amount: value, info: 'order_request' }),
            contentType: 'application/json',
            type: 'POST',
            dataType: 'json',
            success: function (response) {
                console.log(response)
                if (response.status == "created") {
                    let pay = {
                        "key": "rzp_test_GHH9Q147mq0G9x",
                        "amount": response.amount,
                        "currency": "INR",
                        "name": "Teaching Institute",
                        "description": "Test Transaction",
                        "image": "AbhijeetImage.jpg",
                        "order_id": response.id,
                        "handler": function (response) {
                            updatePaymentData(response.razorpay_payment_id);
                            window.location.href="/javaContent1"
                        },
                        "prefill": {
                            "contact": "9508840645"
                        },
                        "notes": {
                            "address": "Razorpay Corporate Office"
                        },
                        "theme": {
                            "color": "#3399cc"
                        }
                    };
                    let razor = new Razorpay(pay);
                    razor.on('payment.failed', function (response){
                            alert("payment unsuccessfully");
                    });
                    razor.open();
                }
            },
            error: function (error) {
                alert("something payment went wrong !!")
            }
        }
    )
};

function updatePaymentData(payment_id,order_id) {
    $.ajax({
        url: "/savePayment",
        data: JSON.stringify({payment_id : payment_id}),
        contentType: 'application/json',
        type: 'POST',
        dataType: 'json',
        success: function (response) {
        },
        error: function (error) {
        }
    })
};