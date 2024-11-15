let bill = {
    urls: {
        listBillByYearAndMonth: ctx + 'barracudabill/bill/rest/listBillByYearAndMonth'
    },
    listBillByYearAndMonth: function (year, month) {
        let data = {
            year, month
        }
        return $.BA.ajax.get(this.urls.listBillByYearAndMonth, data);
    }
}