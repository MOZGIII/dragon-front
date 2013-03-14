L1:	a = 0
L3:	a = 1
L4:	goto L6
L5:	NOOP # label "test"
L7:	a = 2
L8:	NOOP # forward label
L6:	NOOP # label "test1"
L9:	a = 3
L10:	goto L5
L11:	a = 4
L2:
