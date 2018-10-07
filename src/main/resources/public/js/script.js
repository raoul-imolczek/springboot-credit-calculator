var app = new Vue({
    
    el: '#app',

    data: {
        loanAmount: 100000,
        initialContribution: 10000,
        loanDuration: 180,
        rate: null,
        monthlyInstallment: null,
        apr: null
    },

    methods: {
        refreshRate: function(event) {
            $.get('http://localhost:8080/services/pricings/amount/' + (this.loanAmount - this.initialContribution) + '/duration/' + this.loanDuration, function(data, status) {
            	this.rate = data;
            }.bind(this));
        },
        simulate: function(event) {
            this.refreshRate();
        	$.get('http://localhost:8080/services/simulation/amount/' + this.loanAmount + '/contribution/' + this.initialContribution + '/duration/' + this.loanDuration + '/rate/' + this.rate, function(data, status) {
            	this.monthlyInstallment = data.monthlyInstallment;
            	this.apr = data.taeg;
            }.bind(this));
        }
    }

})

app.refreshRate();