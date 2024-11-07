let bill = {
    urls: {
        listBillByMonth: ctx + 'barracudabill/bill/rest/listBillByMonth'
    },
    listBillByMonth: function (month) {
        let data = {
            month
        }
        return $.BA.ajax.get(this.urls.listBillByMonth, data);
    }
}