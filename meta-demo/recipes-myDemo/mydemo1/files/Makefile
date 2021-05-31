obj = main.o
target = hello-world

INCLUDE=include

all: $(obj)
	${CC} ${CFLAGS} $(obj) -o $(target)

%.o:%.c
	${CC} ${CFLAGS} -c $^ -o $@

.PHONY: clean
clean:
	rm -rf $(obj) $(target)
