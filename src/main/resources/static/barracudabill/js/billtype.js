let bill_type = {
    urls: {
        list: ctx + 'barracudabill/billtype/rest/list'
    },
    list: function () {
        return $.BA.ajax.get(this.urls.list);
    },
    getName: function (value, billTypes) {
        let billType = billTypes.find(item => item.code === value);
        return billType ? billType.name : '-';
    }
}