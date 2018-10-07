var app = new Vue({
    
    el: '#app',

    data: {
        loanAmount: 100000,
        initialContribution: 10000,
        loanDuration: 180,
        rate: null
    },

    methods: {
        refreshRate: function(event) {
            $.get('http://localhost:8080/services/pricings/amount/' + this.loanAmount + '/duration/' + this.loanDuration, function(data, status) {
            	this.rate = data;
            }.bind(this));
        }
    }

})

app.refreshRate();