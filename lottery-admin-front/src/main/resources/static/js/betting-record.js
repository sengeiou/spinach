var bettingRecordVM = new Vue({
	el : '#betting-record',
	data : {
		orderNo : '',
		gameDictItems : [],
		gameCode : '',
		startTime : dayjs().format('YYYY-MM-DD'),
		endTime : dayjs().format('YYYY-MM-DD'),
		bettingOrderStateDictItems : [],
		state : ''
	},
	computed : {},
	created : function() {
	},
	mounted : function() {
		this.loadGameDictItem();
		this.loadBettingOrderStateDictItem();
		this.initTable();
	},
	methods : {

		loadGameDictItem : function() {
			var that = this;
			that.$http.get('/dictconfig/findDictItemInCache', {
				params : {
					dictTypeCode : 'game'
				}
			}).then(function(res) {
				this.gameDictItems = res.body.data;
			});
		},

		loadBettingOrderStateDictItem : function() {
			var that = this;
			that.$http.get('/dictconfig/findDictItemInCache', {
				params : {
					dictTypeCode : 'bettingOrderState'
				}
			}).then(function(res) {
				this.bettingOrderStateDictItems = res.body.data;
			});
		},

		initTable : function() {
			var that = this;
			$('.betting-record-table').bootstrapTable({
				classes : 'table table-hover',
				height : 490,
				method : 'post',
				url : globalPrefix + '/betting/findBettingOrderInfoByPage',
				pagination : true,
				sidePagination : 'server',
				pageNumber : 1,
				pageSize : 10,
				pageList : [ 10, 25, 50, 100 ],
				queryParamsType : '',
				ajaxOptions : {
					headers : {
						'Authorization' : localStorage.getItem('jwtToken')
					}
				},
				queryParams : function(params) {
					var condParam = {
						pageSize : params.pageSize,
						pageNum : params.pageNumber,
						orderNo : that.orderNo,
						gameCode : that.gameCode,
						startTime : that.startTime,
						endTime : that.endTime,
						state : that.state
					};
					return condParam;
				},
				responseHandler : function(res) {
					return {
						total : res.data.total,
						rows : res.data.content
					};
				},
				columns : [ {
					field : 'orderNo',
					title : '订单号',
					cellStyle : {
						classes : 'betting-record-order-no'
					}
				}, {
					field : 'gameName',
					title : '游戏'
				}, {
					field : 'bettingTime',
					title : '投注时间'
				}, {
					field : 'issueNum',
					title : '期号'
				}, {
					field : 'stateName',
					title : '状态',
					cellStyle : {
						classes : 'betting-record-state'
					}
				}, {
					field : 'totalBettingAmount',
					title : '投注金额',
					formatter : function(value) {
						return value + '元';
					}
				}, {
					field : 'totalWinningAmount',
					title : '中奖金额',
					formatter : function(value) {
						return value + '元';
					}
				}, {
					field : 'totalProfitAndLoss',
					title : '盈亏',
					formatter : function(value) {
						return value + '元';
					}
				}, {
					title : '操作',
					formatter : function(value, row, index) {
						var btns = [];
						if (row.state == '1') {
							btns.push('<button type="button" class="change-order-btn btn btn-outline-info btn-sm" style="margin-right: 4px;">改单</button>');
						}
						if (row.cancelOrderFlag) {
							btns.push('<button type="button" class="cancel-order-btn btn btn-outline-danger btn-sm" style="margin-right: 4px;">撤单</button>');
						}
						return btns.join('');
					},
					events : {
						'click .change-order-btn' : function(event, value, row, index) {
							changeOrderModalVM.show(row.id, row.gameCode);
						},
						'click .cancel-order-btn' : function(event, value, row, index) {
							that.cancelOrder(row.id);
						}
					}
				} ],
				onClickCell : function(field, value, row) {
					if ('orderNo' == field) {
						bettingOrderDetailsModal.loadAndShowBettingOrderDetails(row.id);
					}
				}
			});
		},
		refreshTable : function() {
			$('.betting-record-table').bootstrapTable('refreshOptions', {
				pageNumber : 1
			});
		},

		cancelOrder : function(orderId) {
			var that = this;
			layer.confirm('确定要撤单吗?', {
				icon : 7,
				title : '提示'
			}, function(index) {
				layer.close(index);
				that.$http.get('/betting/cancelOrder', {
					params : {
						orderId : orderId
					}
				}).then(function(res) {
					layer.alert('操作成功!', {
						icon : 1,
						time : 3000,
						shade : false
					});
					that.refreshTable();
				});
			});
		}
	}
});