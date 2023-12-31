SUMMARY = "Image Generation and Programming Scripts for NPCM7XX (Poleg) devices"
DESCRIPTION = "Image Generation and Programming Scripts for NPCM7XX (Poleg) devices"
HOMEPAGE = "https://github.com/Nuvoton-Israel/igps"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = " \
    git://github.com/Nuvoton-Israel/igps;branch=master;protocol=https \
    file://0001-Adjust-paths-for-use-with-Bitbake.patch \
"
# tag IGPS_02.01.18
SRCREV = "e0fc2ba58d561220a957bc06aefe1ac7f6e96126"

S = "${WORKDIR}/git"

DEST = "${D}${datadir}/${BPN}"

do_install() {
	install -d ${DEST}
	install ImageGeneration/references/BootBlockAndHeader_${IGPS_MACHINE}.xml ${DEST}
	install ImageGeneration/references/UbootHeader_${IGPS_MACHINE}.xml ${DEST}
	install ImageGeneration/inputs/mergedBootBlockAndUboot.xml ${DEST}
}

inherit native
