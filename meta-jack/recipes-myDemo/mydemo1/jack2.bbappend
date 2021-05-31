# Copyright (C) 2014 Boundary Devices
# SUMMARY = "Hello World Demo"
#CFLAGS_prepend = "-I${S}/include"
#INCLUDE = "-I${S}/include"
#
#
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://usb.config"
SRC_URI_append = " file://cfg80211.config"
SRC_URI_append = " file://bcmdhd.config"
SRC_URI_append = " file://gpio.config"
SRC_URI_append = " file://marvell_82q2112.config"
SRC_URI_append = " file://i2c.config"
SRC_URI_append = " file://sensors.config"
SRC_URI_append = " file://thermal.config"
SRC_URI_append = " file://gnss.config"
SRC_URI_append = " file://gpio-poweroff.config"
SRC_URI_append = " file://wsdc.config"
SRC_URI_append = " file://usb1prm1cr.config"
SRC_URI_append = " file://gpio-key.config"
SRC_URI_append = " file://hardware_ver.config"
SRC_URI_append = " file://nfsd.config"


DELTA_KERNEL_DEFCONFIG_ctx0700_es1 += "usb.config"
DELTA_KERNEL_DEFCONFIG_ctx0700_es1 += "cfg80211.config"
DELTA_KERNEL_DEFCONFIG_ctx0700_es1 += "bcmdhd.config"
DELTA_KERNEL_DEFCONFIG_ctx0700_es1 += "gpio.config"
DELTA_KERNEL_DEFCONFIG_ctx0700_es1 += "marvell_82q2112.config"
DELTA_KERNEL_DEFCONFIG_ctx0700_es1 += "i2c.config"
DELTA_KERNEL_DEFCONFIG_ctx0700_es1 += "sensors.config"
DELTA_KERNEL_DEFCONFIG_ctx0700_es1 += "thermal.config"
DELTA_KERNEL_DEFCONFIG_ctx0700_es1 += "gnss.config"
DELTA_KERNEL_DEFCONFIG_ctx0700_es1 += "gpio-poweroff.config"
DELTA_KERNEL_DEFCONFIG_ctx0700_es1 += "usb1prm1cr.config"
DELTA_KERNEL_DEFCONFIG_ctx0700_es1 += "gpio-key.config"
DELTA_KERNEL_DEFCONFIG_ctx0700_es1 += "hardware_ver.config"
DELTA_KERNEL_DEFCONFIG_ctx0700_es1 += "nfsd.config"


 

SUMMARY = "Hello World Demo"
SECTION = "apps"
LICENSE = "CLOSED"

# Please do not add do_compile() or else it will not compile the code
# .bb

do_compile_append() {
    echo "do_compile_append(): jack1.bbappend ******************* " >> LOG1 
}

do_jack1() {
    echo "do_jack1(): jack1.bbappend...." >> LOG1
    echo "{THISDIR}/{PN}=${THISDIR}/${PN}" >> LOG1
    echo "The DELTA_KERNEL_DEFCONFIG_ctx0700_es1=${DELTA_KERNEL_DEFCONFIG_ctx0700_es1}" >> LOG1
    echo "The DELTA_KERNEL_DEFCONFIG=${DELTA_KERNEL_DEFCONFIG}" >> LOG1


    for deltacfg in ${DELTA_KERNEL_DEFCONFIG_ctx0700_es1}; do
        echo "deltacfg=${deltacfg}" >> LOG1
        cat ${deltacfg}  >> LOG1
        cat ${deltacfg}  >> defconfig 
    done

    for deltacfg in ${PREFERRED_VERSION}; do
        echo "Version=${deltacfg}" >> LOG1
        cat ${deltacfg}  >> LOG1
    done

}
