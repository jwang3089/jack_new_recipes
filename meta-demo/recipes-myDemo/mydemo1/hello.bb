SUMMARY = "Hello World Demo"
SECTION = "apps"
LICENSE = "CLOSED"

APP_NAME = "hello-world"

TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI = "file://main.c \
           file://Makefile \
           "

SRC_URI +=  "file://hello1.h"
SRC_URI +=  "file://include/"

S = "${WORKDIR}"
CFLAGS_prepend = "-I${S}/include"
INCLUDE = "-I${S}/include"


do_compile() {
    echo "****************** JACK 1 *********************" > LOG1
    echo "0: CFLAGS_prepend = ${CFLAGS_prepend}" >> LOG1
    echo "0: INCLUDE = ${INCLUDE}" >> LOG1
    echo "0: SRC_URI = ${SRC_URI}" >> LOG1
    echo "0: STAGING_DIR = ${STAGING_DIR}" >> LOG1
    echo "0: STAGING_DIR_TARGET = ${STAGING_DIR_TARGET}" >> LOG1
    echo "0: STAGING_INCDIR = ${STAGING_INCDIR}" >> LOG1
    echo "0: STAGING_LIBDIR = ${STAGING_LIBDIR}" >> LOG1
    echo "0: WORKDIR = ${WORKDIR}" >> LOG1
    echo "0: dir = ${dir}" >> LOG1
    echo "0: libdir = ${libdir}" >> LOG1
    echo "1: D =  ${D}" >> LOG1
    echo "1: localdir =   ${localdir}" >> LOG1
    echo "1: bindir =  ${bindir}" >> LOG1
    echo "2: S = ${S}" >> LOG1
    echo "3: pwd = $(pwd)" >> LOG1
    echo "4: ls= $(ls)" >> LOG1
    echo "5: BASEWORKDIR = $BASEWORKDIR" >> LOG1
    echo "6: WORKDIR = ${WORKDIR}" >> LOG1
    echo "6: PN = ${PN}" >> LOG1
    echo "make -f Makefile" >> LOG1
    make -f Makefile

}

do_install () {
    install -d ${D}${bindir}
    install -d ${D}${bindir}/include
    install -m 0755 hello-world ${D}${bindir}
}

