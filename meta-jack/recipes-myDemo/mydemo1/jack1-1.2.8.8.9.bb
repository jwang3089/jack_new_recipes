# Copyright (C) 2014 Boundary Devices
# SUMMARY = "Hello World Demo"
#CFLAGS_prepend = "-I${S}/include"
#INCLUDE = "-I${S}/include"

#:w
#FILESEXTRAPATHS_prepend := "${THISDIR}/files:" 
#
SUMMARY = "Hello World Demo"
SECTION = "apps"
LICENSE = "CLOSED"

#NOUSE ONLY INFORMATION APP_NAME = "hello-world"
APP_NAME = "jack-world"
# move to INC
#PR = "r5"
#PV = "2.0.1"

# recipe: jack1
# Can not use if we use : 
# PREFERRED_VERSION_jack1 = "1.2.8%" #conf/machine/include/qemu.inc
# PV: 2.0.1
# PR: r5
# jack1/2.0.1-r5

#localdir = "/usr/local"
#bindir = "${localdir}/bin"

TARGET_CC_ARCH += "${LDFLAGS}"


USER="root"
# LIBRARIES WITH .bb
DEPENDS = "glibc openssl"
#DEPENDS = "glibc"

# CREATE: mkdir -p meta-jack/classes
# include jack1.bbclass
inherit jack2

# CREATE: mkdir -p meta-jack/inc
# include jack1.inc
require inc/jack2.inc 

# CREATE: mkdir -p meta-jack/conf
#include jack1.conf
require conf/jack2.conf 

# JACK_IMAE_SIZE == JACK TALL
# no added space
#JACK_IMAGE_SIZE_append = "append"
# no added space
#JACK_IMAGE_SIZE_prepend = "prepend"
# space added  TO THE END
#JACK_IMAGE_SIZE += "plus before"
###JACK_IMAGE_SIZE=JACK TALL plus
# space added TO THE BEGINING
#JACK_IMAGE_SIZE =+ "plus after"
###JACK_IMAGE_SIZE=plus JACK TALL
# no space added
#JACK_IMAGE_SIZE .= "dot before"
# no space added
#JACK_IMAGE_SIZE =. "dot after"
##dot afterJACK TALLdot before
#
# CAN NOT USE IF DEFINE files:// = "${STAGING_KERNEL_DIR}"
S = "${WORKDIR}"

SRC_URI ="file://* \
           "

# 0) 
#
#S = "${WORKDIR}"

#do_compile() {
#    make
#}
#do_compile() {
do_compile_append() {
    echo "****************** JACK 1 *********************" > LOG2
    echo "0: CFLAGS_prepend = ${CFLAGS_prepend}" >> LOG2
    echo "0: INCLUDE = ${INCLUDE}" >> LOG2
    echo "0: SRC_URI = ${SRC_URI}" >> LOG2
    echo "0: WORKDIR = ${WORKDIR}" >> LOG2
    echo "2: S = ${S}" >> LOG2
    echo "3: pwd = $(pwd)" >> LOG2
    echo "4: ls= $(ls)" >> LOG2
    echo "5: BASEWORKDIR = $BASEWORKDIR" >> LOG2
    echo "make -f Makefile" >> LOG2
    echo "CONFIGURATIONS: poky/meta/conf/bitbake.conf" >> LOG2
    echo "STAGING_DIR = ${STAGING_DIR}" >> LOG2
    echo "STAGING_DIR_TARGET = ${STAGING_DIR_TARGET}" >> LOG2
    echo "STAGING_INCDIR = ${STAGING_INCDIR}" >> LOG2
    echo "STAGING_LIBDIR = ${STAGING_LIBDIR}" >> LOG2
    echo "PACKAGES = ${PACKAGES}" >> LOG2
    echo "FILES_{PN} = FILES_${PN}" >> LOG2
    echo "FILES_{PN} contents = ${FILES_${PN}}" >> LOG2
    echo "BPN=${BPN}" >> LOG2
    echo "BP=${BP}" >> LOG2
    echo "PN=${PN}" >> LOG2
    echo "PR=${PR}" >> LOG2
    echo "PV=${PV}" >> LOG2
    echo "PE=${PE}" >> LOG2
    echo "PF=${PF}" >> LOG2
    echo "S=${S}" >> LOG2
    echo "P=${P}" >> LOG2
    echo "B=${B}" >> LOG2
    echo "D=${D}" >> LOG2
    echo "sysconfdir=${sysconfdir}" >> LOG2
    echo "localdir=${localdir}" >> LOG2
    echo "dir = ${dir}" >> LOG2
    echo "libdir=${libdir}" >> LOG2
    echo "bindir=${bindir}" >> LOG2
    echo "sbindir=${sbindir}" >> LOG2
    echo "datadir=${datadir}" >> LOG2
    echo "includedir=${includedir}" >> LOG2
    echo "systemd_system_unitdir=${systemd_system_unitdir}" >> LOG2
    echo "systemd_unitdir=${systemd_unitdir}" >> LOG2
    echo "systemd_libdir=${systemd_libdir}" >> LOG2
    echo "SDKMACHINE=${SDKMACHINE}" >> LOG2
    echo "MACHINE=${MACHINE}" >> LOG2
    echo "TARGET_ARCH=${TARGET_ARCH}" >> LOG2
    echo "TARGET_OS=${TARGET_OS}" >> LOG2
    echo "PACKAGE_ARCH=${PACKAGE_ARCH}" >> LOG2
    echo "TARGET_VENDOR=${TARGET_VENDOR}" >> LOG2
    echo "TOPDIR=${TOPDIR}" >> LOG2
    echo "TMPDIR=${TMPDIR}" >> LOG2
    echo "LAYERDIR=${LAYERDIR}" >> LOG2
    echo "FILE_DIRNAME=${FILE_DIRNAME}" >> LOG2
    echo "FILESPATH=${FILESPATH}" >> LOG2
    echo "FILE=${FILE}" >> LOG2
    echo "DEPLOY_DIR=${DEPLOY_DIR}" >> LOG2
    echo "DEPLOY_DIR_IMAGE=${DEPLOY_DIR_IMAGE}" >> LOG2
    echo "BUILD_ARCH=${BUILD_ARCH}" >> LOG2
    echo "TARGET_ARCH=${TARGET_ARCH}" >> LOG2
    echo "STAGING_DIR_TARGET=${STAGING_DIR_TARGET}" >> LOG2
    echo "BB_ENV_EXTRAWHITE=${BB_ENV_EXTRAWHITE}" >> LOG2
    echo "Build time packages variables"
    echo "DEPENDS=${DEPENDS}" >> LOG2
    echo "PROVIDES=${PROVIDES}" >> LOG2
    echo "Runtime time packages variables"
    echo "RDEPENDS=${RDEPENDS}" >> LOG2
    echo "RRECOMMENDS=${RRECOMMENDS}" >> LOG2
    echo "RSUGGESTS=${RSUGGESTS}" >> LOG2
    echo "RPROVIDES=${RPROVIDES}" >> LOG2
    echo "RCONFLICTS=${RCONFLICTS}" >> LOG2
    echo "RREPLACES=${RREPLACES}" >> LOG2
    echo "PACKAGE_BEFORE_PN=${PACKAGE_BEFORE_PN}" >> LOG2

    echo "env:" >> LOG2
    echo "$(env)" >> LOG2
    echo "printenv:" >> LOG2
    echo "$(printenv)" >> LOG2
    echo "export:" >> LOG2
    echo "$(export)" >> LOG2
#    make clean
    make
}

do_compile_append() {
    echo "do_compile_append(): jack1.bb" >> LOG2
    echo "JACK_BITBAKE=${JACK_BITBAKE}" >> LOG2


}

do_clean() {
    echo "caleup"
}



# include systemd.bbclass
inherit systemd

## systemd:Enable and automatic startup
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "hello.service"
# 0) add openssl, because  main.c:4:25: fatal error: openssl/rsa.h: No such file or directory
#  #include <openssl/rsa.h>

SYSTEMD_SERVICE_${PN} += "sample.service"

do_install_append () {
    install -d ${D}/home/${USER}/.ssh/
# 1) How to create a directory in ROOTFS
    install -d ${D}/jack/user/bin/
    install -d ${D}/jack_008
    install -d ${D}/jack2

#    install -d ${D}/jack/demo/bin/
#    install -m 0755 ${S}/hello.service  ${D}/jack/demo/bin/
#    install -d ${D}/JOHN
#    install -m 0755 ${S}/hello.service  ${D}/JOHN/
#    install -d ${D}${bindir}/jack1 
#    install -d ${D}/jack2

    install -d ${D}${bindir}
    install -d ${D}${libdir}
    install -d ${D}${sysconfdir}
    install -d ${D}${systemd_unitdir}/system
    install -d ${D}${sysconfdir}
# 2) Copy a files into /jack/user/bin/ ROOTFS
#    install -m 0755 ${S}/hello-world ${D}${bindir}
#    install -m 0755 ${S}/hello-world ${D}/home/
    install -m 0755 ${S}/Makefile ${D}/home/${USER}/.ssh/
    install -m 0755 ${S}/hello-world  ${D}/home/${USER}/
    install -m 0755 ${S}/main.c  ${D}${bindir}
    install -m 0755 ${S}/hello1.h  ${D}${libdir}
    install -m 0755 ${S}/hello.h  ${D}${sysconfdir}
    install -m 0755 ${S}/hello.service  ${D}${systemd_unitdir}/system
    install -m 0755 ${S}/sample.service  ${D}${systemd_unitdir}/system
    install -m 0755 ${S}/hello.service  ${D}/jack/user/bin/
    install -m 0755 ${S}/hello.service  ${D}${sysconfdir}

# 3) calling bbclass the bbclass needs to be in the class directory
    do_jack
# 4) calling bbappend the bbappend needs to be in the same recipe directory
    do_jack1
# 4) calling inc the inc needs to be in the same recipe directory
    do_jack2
}


#FILES_${PN}-jhon = "/JOHN/"
#FILES_${PN}-jack2 = "jack2"
# METHOD 1 add directories/files to rootfs correct
#FILES_${PN}-demo1 = "${bindir}/jack1 "
#FILES_${PN}-demo = "/jack/demo/bin/"
#FILES_${PN}-jack-systemD = "${systemd_unitdir}/system"

#PACKAGES += "${PN}-jhon "
#PACKAGES += "${PN}-demo1"
#PACKAGES += "${PN}-demo"
#PACKAGES += "${PN}-jack-systemD"
#PACKAGES += "${PN}-jack2"

#FILES_${PN} += "${FILES_${PN}-jack2} ${FILES_${PN}-demo1} ${FILES_${PN}-demo} ${FILES_${PN}-jack-systemD} ${FILES_${PN}-jhon}" 

#PACKAGES += "FILES-${PN}-jhon "
#FILES-${PN}-jhon += " /JOHN/"
## WORKING......
#FILES_${PN} += "/JOHN/"

# METHOD 1 add directories/files to rootfs iWRONG
# WRONG: PACKAGES += "${PN}-sample"
# WRONG: FILES_${PN}-sample += "/jack/demo/bin/"


# METHOD 2 use packagegroup to add directorees/files to rootfs
# All these entries: ${PN}-jack-ssh ${PN}-jack-bin ${PN}-jack-bindir ${PN}-jack-libdir // defined in packagroup-XXXXX.bb
# All these entries: jack1-jack-ssh jack1-jack-bin jack1-jack-bindir jack1-jack-libdir // defined in packagroup-XXXXX.bb
PACKAGE_BEFORE_PN = "sample-jack2 ${PN}-jack-ssh ${PN}-jack-bin ${PN}-jack-bindir ${PN}-jack-libdir ${PN}-008 ${PN}-jack-hello-world ${PN}-jack-systemd"
#FILES_${PN}-jack1 += "/jack/user/bin ${bindir} ${libdir} ${sysconfdir}/systemd /home/root/.ssh ${systemd_unitdir}/system"

#FILES_${PN}-jack2 += "/jack2"
FILES_sample-jack2 += "/jack2"
#
# 3) ADD the /jack/user/bin/ and it contents into the PACKAGES
FILES_${PN}-jack-bin += "/jack/user/bin"
#FILES_${PN} += "/jack/user/bin"
#
# /usr/bin
FILES_${PN}-jack-bindir += "${bindir}"
#FILES_${PN} += "${bindir}"

# /usr/lib
FILES_${PN}-jack-libdir += "${libdir}"
#FILES_${PN} += "${libdir}"

# /etc
#FILES_${PN}-jack-SYSTEMD1 += "${sysconfdir}/systemd"
#FILES_${PN} += "${sysconfdir}/systemd"

# /lib/systemd
#FILES_${PN}-jack-systemD += "${systemd_unitdir}/system"
#FILES_${PN} += "${systemd_unitdir}/system"

FILES_${PN}-jack-ssh += "/home/root/.ssh"
FILES_${PN}-008 += "/jack_008"
#FILES_${PN} = "/home/root/.ssh"

FILES_${PN}-jack-hello-world += "/home/root/"

FILES_${PN}-jack-systemd += "${systemd_unitdir}/system"

# 5) add conf.local.conf 
# jack1 is the recipe name
# IMAGE_INSTALL_append +="jack1"


#FILES_${PN}-fip += "${datadir}/fip"

