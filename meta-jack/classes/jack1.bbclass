# Copyright (C) 2014 Boundary Devices
# SUMMARY = "Hello World Demo"
#CFLAGS_prepend = "-I${S}/include"
#INCLUDE = "-I${S}/include"

# functionname
#add or remove still works
#addtask do_jack

#classname_do_functionna0me
#jack2_1.1.0_do_build() {
do_compile_append() {
    echo "do_compile_append(): jack1.bbclass" >> LOG1
}

do_jack() {
    echo "do_jack(): jack1.bbclass......" >> LOG1
    echo "************* do_jack_bbclass(): jack1.bbclass ******************* " >> LOG1
}

# add do_build
#add or remove still works
#EXPORT_FUNCTIONS do_jack
