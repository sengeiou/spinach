var lotteryHistorySscVM = new Vue({
	el : '#lottery-history-ssc',
	data : {
		gameCode : '',
		gameName : '',
		showStatisticalDoubleSidedFlag : false,
		numAppearNumberOfTime : [],
		ballNumberOfTime : [],
		showStatisticalLoongFlag : false,
		loongs : [],
		showStatisticalNumFlag : false,
		selectedBigFlag : false,
		selectedSmallFlag : false,
		selectedSingleFlag : false,
		selectedDoubleFlag : false,
		selectedTwinNumberFlag : false,
		twinNumberMap : null,
		nums : [ {
			num : 0,
			selectedFlag : false
		}, {
			num : 1,
			selectedFlag : false
		}, {
			num : 2,
			selectedFlag : false
		}, {
			num : 3,
			selectedFlag : false
		}, {
			num : 4,
			selectedFlag : false
		}, {
			num : 5,
			selectedFlag : false
		}, {
			num : 6,
			selectedFlag : false
		}, {
			num : 7,
			selectedFlag : false
		}, {
			num : 8,
			selectedFlag : false
		}, {
			num : 9,
			selectedFlag : false
		} ],
		lotteryDate : dayjs().format('YYYY-MM-DD'),
		displayMode : 'number',
		issues : [],
	},
	computed : {},
	created : function() {
	},
	mounted : function() {
		this.gameCode = getQueryString('gameCode');
		this.loadGameInfo();
		this.loadLotteryHistory();
		this.statisticalDoubleSided();
	},
	methods : {

		loadGameInfo : function() {
			var that = this;
			that.$http.get('/game/findGameByGameCode', {
				params : {
					gameCode : that.gameCode
				}
			}).then(function(res) {
				that.gameName = res.body.data.gameName;
			});
		},

		toggleStatisticalDoubleSided : function() {
			this.showStatisticalDoubleSidedFlag = !this.showStatisticalDoubleSidedFlag;
		},

		selectedNum : function(num) {
			this.resetBigSmallSingleDouble();
			num.selectedFlag = !num.selectedFlag;
		},

		selectedBig : function() {
			this.resetSelectedNum();
			this.selectedSmallFlag = false;
			this.selectedTwinNumberFlag = false;
			this.selectedBigFlag = !this.selectedBigFlag;
		},

		selectedSmall : function() {
			this.resetSelectedNum();
			this.selectedBigFlag = false;
			this.selectedTwinNumberFlag = false;
			this.selectedSmallFlag = !this.selectedSmallFlag;
		},

		selectedSingle : function() {
			this.resetSelectedNum();
			this.selectedDoubleFlag = false;
			this.selectedTwinNumberFlag = false;
			this.selectedSingleFlag = !this.selectedSingleFlag;
		},

		selectedDouble : function() {
			this.resetSelectedNum();
			this.selectedSingleFlag = false;
			this.selectedTwinNumberFlag = false;
			this.selectedDoubleFlag = !this.selectedDoubleFlag;
		},

		selectedTwinNumber : function() {
			this.resetSelectedNum();
			this.selectedBigFlag = false;
			this.selectedSmallFlag = false;
			this.selectedSingleFlag = false;
			this.selectedDoubleFlag = false;
			this.selectedTwinNumberFlag = !this.selectedTwinNumberFlag;
		},

		resetSelectedNum : function() {
			for (var i = 0; i < this.nums.length; i++) {
				this.nums[i].selectedFlag = false;
			}
		},

		resetBigSmallSingleDouble : function() {
			this.selectedBigFlag = false;
			this.selectedSmallFlag = false;
			this.selectedSingleFlag = false;
			this.selectedDoubleFlag = false;
			this.selectedTwinNumberFlag = false;
		},

		getSelectedNum : function() {
			var selectedNums = [];
			for (var i = 0; i < this.nums.length; i++) {
				if (this.nums[i].selectedFlag) {
					selectedNums.push(this.nums[i].num);
				}
			}
			return selectedNums;
		},

		getNumClass : function(issueNum, index, num) {
			if (this.displayMode == 'number') {
				var selectedFlag = true;
				var bigSmallSingleDoubleFlag = false;
				if (this.selectedBigFlag) {
					selectedFlag = num > 4;
					bigSmallSingleDoubleFlag = true;
				}
				if (this.selectedSmallFlag) {
					selectedFlag = num <= 4;
					bigSmallSingleDoubleFlag = true;
				}
				if (this.selectedSingleFlag) {
					selectedFlag = selectedFlag && (num % 2 != 0);
					bigSmallSingleDoubleFlag = true;
				}
				if (this.selectedDoubleFlag) {
					selectedFlag = selectedFlag && (num % 2 == 0);
					bigSmallSingleDoubleFlag = true;
				}
				if (this.selectedTwinNumberFlag) {
					selectedFlag = this.twinNumberMap.get(issueNum + '_' + index);
					bigSmallSingleDoubleFlag = true;
				}
				if (bigSmallSingleDoubleFlag) {
					return selectedFlag ? '' : 'ssc-unselected-number';
				}

				selectedFlag = false;
				var selectedNums = this.getSelectedNum();
				if (selectedNums.length == 0) {
					return '';
				}
				for (var i = 0; i < selectedNums.length; i++) {
					if (selectedNums[i] == num) {
						selectedFlag = true;
					}
				}
				return selectedFlag ? '' : 'ssc-unselected-number';
			} else if (this.displayMode == 'bigSmall') {
				return num == '小' ? 'ssc-highlight-small' : 'ssc-highlight-big';
			} else if (this.displayMode == 'singleDouble') {
				return num == '单' ? 'ssc-highlight-single' : 'ssc-highlight-double';
			}
			return '';
		},

		splitLotteryNum : function(issue) {
			var lotteryNum = [];
			if (this.displayMode == 'number') {
				lotteryNum = issue.lotteryNum;
			} else if (this.displayMode == 'bigSmall') {
				lotteryNum = issue.extField.bigSmall;
			} else if (this.displayMode == 'singleDouble') {
				lotteryNum = issue.extField.singleDouble;
			}
			if (lotteryNum == null || lotteryNum == '') {
				return [];
			}
			return lotteryNum.split(',');
		},

		statisticalTwinNumber : function() {
			var twinNumberMap = new Map();
			for (var i = 0; i < this.issues.length - 1; i++) {
				var lotteryNum1 = this.issues[i].lotteryNum;
				var lotteryNum2 = this.issues[i + 1].lotteryNum;
				if (lotteryNum1 == null || lotteryNum1 == '') {
					continue;
				}
				if (lotteryNum2 == null || lotteryNum2 == '') {
					continue;
				}
				var lotteryNums1 = lotteryNum1.split(',');
				var lotteryNums2 = lotteryNum2.split(',');
				for (var j = 0; j < lotteryNums1.length; j++) {
					if (lotteryNums1[j] == lotteryNums2[j]) {
						twinNumberMap.set(this.issues[i].issueNum + '_' + j, true);
						twinNumberMap.set(this.issues[i + 1].issueNum + '_' + j, true);
					} else {
						var twinNumberFlag1 = twinNumberMap.get(this.issues[i].issueNum + '_' + j);
						var twinNumberFlag2 = twinNumberMap.get(this.issues[i + 1].issueNum + '_' + j);
						twinNumberMap.set(this.issues[i].issueNum + '_' + j, twinNumberFlag1 != null ? twinNumberFlag1 || false : false);
						twinNumberMap.set(this.issues[i + 1].issueNum + '_' + j, twinNumberFlag2 != null ? twinNumberFlag2 || false : false);
					}
				}
			}
			this.twinNumberMap = twinNumberMap;
		},

		statisticalDoubleSided : function() {
			var that = this;
			that.$http.post('/issue/findLotteryHistory', {
				gameCode : that.gameCode,
				lotteryDate : dayjs().format('YYYY-MM-DD')
			}).then(function(res) {
				that.statisticalDoubleSidedInner(res.body.data);
			});
		},

		statisticalDoubleSidedInner : function(issues) {
			var numAppearNumberOfTime = [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ];
			var ballNumberOfTime = [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ];
			for (var i = 0; i < issues.length; i++) {
				var lotteryNum = issues[i].lotteryNum;
				if (lotteryNum == null || lotteryNum == '') {
					continue;
				}
				var lotteryNums = lotteryNum.split(',');
				for (var j = 0; j < lotteryNums.length; j++) {
					numAppearNumberOfTime[lotteryNums[j]] = numAppearNumberOfTime[lotteryNums[j]] + 1;

				}
				var singleDoubles = issues[i].extField.singleDouble.split(',');
				var bigSmalls = issues[i].extField.bigSmall.split(',');
				for (var j = 0; j < singleDoubles.length; j++) {
					ballNumberOfTime[j * 4 + 0] = (singleDoubles[j] == '单' ? ballNumberOfTime[j * 4 + 0] + 1 : ballNumberOfTime[j * 4 + 0]);
					ballNumberOfTime[j * 4 + 1] = (singleDoubles[j] == '双' ? ballNumberOfTime[j * 4 + 1] + 1 : ballNumberOfTime[j * 4 + 1]);
					ballNumberOfTime[j * 4 + 2] = (bigSmalls[j] == '大' ? ballNumberOfTime[j * 4 + 2] + 1 : ballNumberOfTime[j * 4 + 2]);
					ballNumberOfTime[j * 4 + 3] = (bigSmalls[j] == '小' ? ballNumberOfTime[j * 4 + 3] + 1 : ballNumberOfTime[j * 4 + 3]);
				}
				ballNumberOfTime[20] = (issues[i].extField.sumSingleDouble == '单' ? ballNumberOfTime[20] + 1 : ballNumberOfTime[20]);
				ballNumberOfTime[21] = (issues[i].extField.sumSingleDouble == '双' ? ballNumberOfTime[21] + 1 : ballNumberOfTime[21]);
				ballNumberOfTime[22] = (issues[i].extField.sumBigSmall == '大' ? ballNumberOfTime[22] + 1 : ballNumberOfTime[22]);
				ballNumberOfTime[23] = (issues[i].extField.sumBigSmall == '小' ? ballNumberOfTime[23] + 1 : ballNumberOfTime[23]);
			}
			this.numAppearNumberOfTime = numAppearNumberOfTime;
			this.ballNumberOfTime = ballNumberOfTime;

			var loongMap = new Map();
			var firstLoongFlag = true;
			var firstIndex = 0;
			var firstIssue = issues[firstIndex];
			while (firstIssue != null && (firstIssue.lotteryNum == null || firstIssue.lotteryNum == '')) {
				firstIndex++;
				firstIssue = issues[firstIndex];
			}
			if (firstIssue == null) {
				return;
			}
			var singleDoubles = firstIssue.extField.singleDouble.split(',');
			var bigSmalls = firstIssue.extField.bigSmall.split(',');
			for (var i = firstIndex + 1; i < issues.length; i++) {
				var lotteryNum2 = issues[i].lotteryNum;
				if (lotteryNum2 == null || lotteryNum2 == '') {
					continue;
				}

				if (firstIssue.extField.sumSingleDouble == issues[i].extField.sumSingleDouble) {
					this.recordLoong(loongMap, 5, firstIssue.extField.sumSingleDouble, firstIndex, i);
				}
				if (firstIssue.extField.sumBigSmall == issues[i].extField.sumBigSmall) {
					this.recordLoong(loongMap, 5, firstIssue.extField.sumBigSmall, firstIndex, i);
				}
				if (firstIssue.extField.loongTiger == issues[i].extField.loongTiger) {
					this.recordLoong(loongMap, 6, firstIssue.extField.loongTiger, firstIndex, i);
				}
				var singleDoubles2 = issues[i].extField.singleDouble.split(',');
				var bigSmalls2 = issues[i].extField.bigSmall.split(',');
				for (var j = 0; j < singleDoubles2.length; j++) {
					if (singleDoubles[j] == singleDoubles2[j]) {
						this.recordLoong(loongMap, j, singleDoubles[j], firstIndex, i);
					}
					if (bigSmalls[j] == bigSmalls2[j]) {
						this.recordLoong(loongMap, j, bigSmalls[j], firstIndex, i);
					}
				}
			}
			var loongs = [];
			loongMap.forEach(function(value, key) {
				loongs.push(value);
			});
			loongs.sort(function(a, b) {
				return b.count - a.count;
			});
			this.loongs = loongs;
		},

		recordLoong : function(loongMap, position, loongType, firstIndex, issueIndex) {
			var positionName = '';
			if (position <= 4) {
				positionName = '第' + (position + 1) + '球';
			} else if (position == 5) {
				positionName = '总和';
			} else if (position == 6) {
				positionName = '龙虎';
			}
			var loong = loongMap.get(position + '_' + loongType);
			if (loong == null && issueIndex == firstIndex + 1) {
				loongMap.set(position + '_' + loongType, {
					position : position,
					positionName : positionName,
					loongType : loongType,
					count : 2
				});
			} else if (loong != null && (issueIndex - firstIndex == loong.count)) {
				loongMap.set(position + '_' + loongType, {
					position : position,
					positionName : positionName,
					loongType : loongType,
					count : loong.count + 1
				});
			}
		},

		loadLotteryHistory : function() {
			var that = this;
			if (that.lotteryDate == null || that.lotteryDate == '') {
				layer.alert('请选择日期!', {
					title : '提示',
					icon : 7,
					time : 3000
				});
				return;
			}
			that.$http.post('/issue/findLotteryHistory', {
				gameCode : that.gameCode,
				lotteryDate : that.lotteryDate
			}).then(function(res) {
				that.issues = res.body.data;
				that.statisticalTwinNumber();
			});
		}
	}
});