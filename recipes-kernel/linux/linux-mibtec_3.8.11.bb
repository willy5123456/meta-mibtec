SECTION = "kernel"
DESCRIPTION = "Linux kernel for TI devices used by mibtec"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
KERNEL_IMAGETYPE = "uImage"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc

# Add a run-time dependency for the PM firmware to be installed
# on the target file system.
RDEPENDS_ti33x += "am33x-cm3"

# Default is to package all dts files for ti33x devices unless building
# for the specific beaglebone machine.
#KERNEL_DEVICETREE_ti33x = "arch/arm/boot/dts/am335x-evm.dts arch/arm/boot/dts/am335x-evmsk.dts arch/arm/boot/dts/am335x-bone.dts"
KERNEL_DEVICETREE_ti33x = "arch/arm/boot/dts/am335x-boneblack.dts"
KERNEL_DEVICETREE_beaglebone = "arch/arm/boot/dts/am335x-bone.dts"
KERNEL_DEVICETREE_omap5-evm = "arch/arm/boot/dts/omap5-sevm.dts arch/arm/boot/dts/omap5-uevm.dts"

COMPATIBLE_MACHINE = "ti33x|omap-a15"

S = "${WORKDIR}/mibtec-kernels"

BRANCH = "3.8.11-dev"

# This commit corresponds to ti2013.04.00 release tag
SRCREV = "23e7f725a6af4ca44660c06bc3569f6ce705d1d0"
PV = "3.8.11"

# Append to the MACHINE_KERNEL_PR so that a new SRCREV will cause a rebuild
MACHINE_KERNEL_PR_append = "b+gitr${SRCPV}"

#SRC_URI = "git://home.mibtec.de/linux/kernel/mibtec-kernels;protocol=git;branch=${BRANCH} \
#           file://defconfig \
#          "

SRC_URI = "http://home.mibtec.de/linux/kernel/linux-mibtec-3.8.11.tar.bz2 \
           file://defconfig \
          "

