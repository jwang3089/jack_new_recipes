# Copyright (C) 2014 Boundary Devices
# SUMMARY = "Hello World Demo"
#CFLAGS_prepend = "-I${S}/include"
#INCLUDE = "-I${S}/include"


PR = "r5"
#PV = "2.0.2"


# functionname
#add or remove still works
#addtask do_jack

do_compile_append() {
    echo "do_compile_append(): jack1.inc ******************* " >> LOG2
}


#classname_do_functionna0me
#jack2_1.1.0_do_build() {
do_jack2() {
    echo "do_jack2(): inc....." >> LOG2
    echo "************* do_jack_inc(): jack1.inc ******************* " >> LOG2
}

# add do_build
#add or remove still works
#EXPORT_FUNCTIONS do_jack
